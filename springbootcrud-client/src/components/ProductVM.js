import constants from '@/components/constants'

export default {
  name: 'product',
  components: {},
  data: function () {
    return {
      visible: false,
      context: 'Product',
      product: initProduct(),
      typeOptions: ['Book', 'Board Games', 'Pensil', 'Gadget'],
      rules: {
        productName:[ {
          required: true,
          message: "Only characters",
          pattern: /^[a-zA-Z]+$/,
          trigger: 'blur'
        },
          {
          required: false,
          min: constants.sizes.SIZE_XXXS,
          max: constants.sizes.SIZE_M,
          trigger: 'blur'
        }
      ],
      type:{},
      barCode:{
        required: false,
        min: constants.sizes.SIZE_XXXS,
        max: constants.sizes.SIZE_M,
        trigger: 'blur'
      }
      }
    }
  },
  created () {
    console.log('Product created')
  },
  mounted () {
    this.$events.$on('edit-product', eventData => this.onEditProduct(eventData))
    console.log('Product mounted')
  },
  destroyed: function () {
    this.$events.$off('edit-product')
    console.log('Product destroyed')
  },
  computed: {
    isDeletable: function () {
      return this.product.id != null
    }
  },
  methods: {
    onEditProduct (eventData) {
      console.log('Edit Product:' + eventData)
      if (eventData != null) {
        this.$http.get('products/' + eventData.id)
          .then(response => {
            this.product = response.data
            this.visible = true
            this.clearValidation()
          })
      } else {
        Object.assign(this.$data.product, initProduct())
        this.visible = true
        this.clearValidation()
      }
    },
    save () {
      this.$refs['productForm'].validate().then(() => {
        let _self = this
        if (this.product.id != null) {
          // existing product, update
          this.$http.patch('products/' + this.product.id, this.product, {
            // transform the selected roles into URIs, before sending
            transformRequest: [function (data, headers) {
              return _self.transformRequest(data)
            }]
          }).then(response => {
            this.handleSuccess(response)
          }).catch(e => this.handleError(e))
        } else {
          // new product, create
          this.$http.post('products', this.product, {
            // transform the selected roles into URIs, before sending
            transformRequest: [function (data, headers) {
              return _self.transformRequest(data)
            }]
          }).then(response => this.handleSuccess(response))
            .catch(e => this.handleError(e))
        }
      }).catch(e => {
        console.error('validation FAILED')
      })
    },
    cancel () {
      this.visible = false
      this.clearValidation()
    },
    handleSuccess (response) {
      this.visible = false
      this.successFloat(this.$messages.successAction)
      console.log('fire product-edited event')
      this.$events.fire('product-edited', this.product)
    },
    handleError (e) {
      this.showDefaultError(e)
    },
    confirmDelete () {
      this.$confirm(this.$messages.confirmAction, this.$messages.confirmActionTitle, {
        confirmButtonText: this.$messages.yes,
        cancelButtonText: this.$messages.no,
        cancelButtonClass: 'btn btn-warning',
        confirmButtonClass: 'btn btn-danger',
        closeOnClickModal: false,
        closeOnPressEscape: false,
        type: 'warning'
      }).then(() => {
        // delete product
        this.$http.delete('products/' + this.product.id).then(response => this.handleSuccess(response))
      })
    },
    transformRequest (data) {
    //   if (data.mobilePhone === '') {
    //     delete data.mobilePhone
    //   }
      return JSON.stringify(data)
    },
    clearValidation () {
      if (this.$refs['productForm']) {
        this.$refs['productForm'].clearValidate()
      }
    }
  }
}

/**
 * Create a new totally empty Person
 * @returns {{id: null, name: string, mobilePhone: string, gender: null, email: string, comments: string, active: boolean}}
 */
function initProduct () {
  return {
    id: null,
    productName: '',
    type: null,
    barCode: '',
  }
}
