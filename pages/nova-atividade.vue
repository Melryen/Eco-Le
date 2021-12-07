<template>
  <div>
    <Navegacao></Navegacao>
    <div class="container">
      <h2>Adicionar Nova Atividade</h2>

      <b-form @submit.prevent="criarAtividade">
        <b-form-group
          id="input-group-1"
          label="Título da Nova Atividade:"
          label-for="titulo"
        >
          <b-form-input
            id="titulo"
            v-model="form.titulo"
            placeholder="Insira um titulo"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="Matéria:" label-for="materia">
          <b-form-select
            id="materia"
            v-model="form.materia"
            :options="materias"
            :value="null"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group
          id="input-group-1"
          label="Data de criação:"
          label-for="data de criação"
        >
          <b-form-input
            id="data de criação"
            v-model="form.dataCriacao"
            placeholder="Insira a data:"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">Criar</b-button>
        <b-button type="reset" variant="danger">Limpar</b-button>
      </b-form>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      form: {
        titulo: '',
        materia: null,
        dataCriacao: '',
      },
      materias: [
        { text: 'Selecione uma matéria', value: null },
        'Geografia',
        'Matemática',
        'Portugues',
        'História',
      ],
    }
  },

  methods: {

    async criarAtividade(event) {
        console.log("entrou")
   
      try {
        let novaAtividade = {
          titulo: this.form.titulo,
          materia: this.form.materia,
          dataCriacao: this.form.dataCriacao,
        }
        console.log(novaAtividade)
        let dataAtividade = await this.$axios.$post('/atividade', novaAtividade)
        console.log(dataAtividade)
        if (dataAtividade !== null) {
          this.$bvModal.msgBoxOk('A nova atividade foi criada com sucesso'),
            {
              title: 'Confirmation',
              size: 'sm',
              buttonSize: 'sm',
              okVariant: 'success',
              headerClass: 'p-2 border-bottom-0',
              footerClass: 'p-2 border-top-0',
              centered: true,
            },
            this.limparCampos()
        }
      } catch (error) {
          console.log(error)
      }
    },

    limparCampos() {
      this.form = {
        titulo: '',
        materia: '',
        descricao: '',
      }
    },
  },
}
</script>