import Product from '@/components/Product'

export default {
  components: {
    Product
  },
  created () {
    this.refreshProducts()
    console.log('Products created')
  },
  mounted () {
    // subscribe to the 'row-selected' event (wherever it may come from, should come from the child table component)
    this.$events.$on('row-selected', eventData => this.onProductSelected(eventData))
    this.$events.$on('product-edited', eventData => this.onProductEdited(eventData))
    console.log('Products mounted')
  },
  beforeDestroy () {
    // un-subscribe from events
    this.$events.$off('row-selected')
    this.$events.$off('product-edited')
  },
  destroyed () {
    console.log('Products destroyed')
  },
  data: function () {
    return {
      url: 'products/search/findByQuery?query=',
      query: '',
      products: [],
      fields: [
        {
          name: 'id',
          title: 'Α/Α',
          sortField: 'id'
        },
        {
          name: 'productName',
          title: 'Όνομα',
          sortField: 'productName'
        },
        {
          name: 'type',
          title: 'Τυπος',
          sortField: 'type'
        },
        {
            name: 'barCode',
            title: 'Βar Code',
            sortField: 'barCode'
          }
      ]
    }
  },
  watched: {
    query: function (newValue) {
      this.query = newValue
      console.log(newValue)
      this.refreshProducts()
    }
  },
  methods: {
    createProduct (event) {
      console.log('fire edit-product event')
      this.$events.fire('edit-product', null)
    },
    onProductSelected (dataItem) {
      console.log('fire edit-product event')
      this.$events.fire('edit-product', dataItem)
    },
    onProductEdited (dataItem) {
      this.refreshProducts()
    },
    refreshProducts () {
      this.$http.get(this.url + this.query)
        .then(response => {
          this.products = response.data._embedded.products
        })
        .catch(e => {
          console.log('error: ')
          console.log(e)
        })
    }
  }
}
