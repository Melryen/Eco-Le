<template>
  <div>
    <Navegacao> </Navegacao>
    <div class="mx-auto" style="max-width: 1000px; padding: 30px">
      <h1>{{ atividade.titulo }}</h1>
      <div id="espaco">
        <b-button @click="showModal = true" pill variant="dark">
          
          <h4 id="criar">Criar Questão</h4>
        
        </b-button>
      </div>
      <ul>
        <li :key="questao" v-for="questao in atividade.questoes">
          <b-form-checkbox size="sm" v-model="questao.checked">
            {{ questao.enunciado}}
            {{ questao.respostaCorreta }}
          </b-form-checkbox>
        </li>
      </ul>

      <b-modal id="modal-questao" size="lg" v-model="showModal" hide-footer>
        <h1 class="tit">Nova Questão</h1>
        <div id="linhas">
        <b-container fluid>
          <b-row class="my-1">
            <b-col sm="2">
              <label for="questao">Enunciado:</label>
            </b-col>
            <b-col sm="10">
              <b-form-input
                id="questao"
                size="sm"
                placeholder="Enunciado..."
                v-model="novaQuestao.enunciado"
              ></b-form-input>
            </b-col>

           </b-row>
           <b-row class="my-1">
            <b-col sm="2">
              <label for="questao">Resposta:</label>
            </b-col>
            <b-col sm="10">
              <b-form-input
                id="questao"
                size="sm"
                placeholder="Resposta"
                v-model="novaQuestao.respostaCorreta"
              ></b-form-input>
            </b-col>
           
          </b-row>
        </b-container>
        </div>
        <div id="but">
        <b-button id="button" class="mt-3" block variant="success" @click="criarNovaQuestao "
          >Criar Questão</b-button>
        <b-button id="button" class="mt-3" block variant="danger" @click="fecharModal">Fechar
        </b-button>
        </div>
      </b-modal>
    </div>
  </div>
</template>

<script>
export default {
  
  async asyncData({ $axios, params }) {
    let atividade
    try {
      // URL Final: http://localhost:8080/atividade/{id}
      atividade = await $axios.$get(`/atividade/${params.questao}`)
      // data = response
    } catch (e) {
      
      console.log(e)
    }
    console.log(JSON.stringify(atividade))
    return { atividade }
  },
  data: function () {
    return {
      showModal: false,
      novaQuestao: {
        enunciado: '',
        respostaCorreta: '',
      },
      selecionados: [],
    }
  },
  methods: {
    async criarNovaQuestao(event) {
      
      try {
        let dataQuestao = await this.$axios.$get(
          `/atividade/${this.atividade.id}`,
          this.novaQuestao
        )
        if (dataQuestao !== null) {
          this.fecharModal(event)
          this.novaQuestao = {
            questao: '',
            respostaCorreta: null,
          }
          this.atualizaAtividadeQuestao();
        } else{
          throw new Error(`Questão para a atividade de id ${this.atividade.id} não foi criada!`);
        }
      } catch (error) {
        console.log(error)
      }
    },
    async atualizaAtividadeQuestao(){
      this.atividade = await this.$axios.$get(`/atividade/${this.atividade.id}`);
    },
    fecharModal(event) {
      this.$bvModal.hide('modal-questao')
    },
    
  },
}
</script>