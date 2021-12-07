<template>
  <div>
    <Navegacao /> 
      <div class="container">
        <h2>Lista de Atividades</h2>

        <b-table striped responsive hover :items="atividades" :fields="campos">
          <template #cell(titulo)="data">
            <NuxtLink :to="`/atividade/${data.item.id}`">
              <span>{{ data.value }}</span>
            </NuxtLink>
          </template>
        </b-table>
      </div>
    
  </div>
</template>

<script>
export default {
  async asyncData({ $axios }) {
    let atividades
    try {
      atividades = await $axios.$get('/atividade')
    } catch (e) {
      console.log(e)
    }
    console.log(JSON.stringify(atividades))
    return { atividades }
  },

  data: function () {
    return {
      campos: [
        {
          key: 'titulo',
        },
        {
          key: 'materia',
        },
        {
          key: 'dataCriacao',
          label: 'Criado em',
        },
      ],
      /*atividades: [
        {
          titulo: 'Fauna',
          materia: 'Geografia',
          dataCriacao: '03/12/2021',
          id: 1,
        },
        {
          titulo: 'Números pares',
          materia: 'Matemática',
          dataCriacao: '03/12/2021',
          id: 2,
        },
        {
          titulo: 'Alfabeto',
          materia: 'Portugues',
          dataCriacao: '03/12/2021',
          id: 3,
        },
      ],*/
    }
  },
}
</script>


