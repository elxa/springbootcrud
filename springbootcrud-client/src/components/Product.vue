<template>
  <el-dialog
    type="warning"
    title="Διαχείριση Προιοντος"
    :visible="visible"
    :modal="true"
    :close-on-click-modal="false"
    :close-on-press-escape="false"
    :modal-append-to-body="false"
    :show-close="false"
    width="75%"
    @close="clearValidation"
  >
    <el-card>
      <el-form ref="productForm" :model="product" :rules="rules" label-position="top">
        <el-row :gutter="20">
          <!-- LEFT COLUMN -->
          <el-col :span="12">
            <el-form-item label="Εισάγετε το όνομα του Προιοντος" prop="productName">
              <el-input
                prefix-icon="fa fa-user"
                v-model="product.productName"
                placeholder="Όνομα Προιοντος"
                autocomplete="productName"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε το Bar code" prop="barCode">
              <el-input
                prefix-icon="fa fa-user"
                v-model="product.barCode"
                placeholder="Bar Code"
                autocomplete="barCode"
              ></el-input>
            </el-form-item>
          </el-col>
          <!-- RIGHT COLUMN -->
             <el-col :span="12">
            <el-form-item label="Επιλέξτε Tυπο" prop="type">
              <template>
                <el-select
                  v-model="product.type"
                  placeholder="Tυπο"
                  value-key="id"
                  filterable
                  clearable
                >
                <!-- 8elei ftia3imo -->
                  <el-option
                    v-for="item in typeOptions"
                    :key="item.id"
                    :label="item.title"
                    :value="item"
                  ></el-option>
                </el-select>
              </template>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>

      <el-row>
        <el-col style="text-align: right">
          <el-button type="success" icon="fa fa-save" @click="save">Αποθήκευση</el-button>

          <el-button
            type="danger"
            icon="fa fa-remove"
            @click="confirmDelete"
            :disabled="!isDeletable"
          >Διαγραφή</el-button>
        </el-col>
      </el-row>
    </el-card>
    <div slot="footer" class="dialog-footer card-footer">
      <el-button type="warning" icon="el-icon-back" @click="cancel">Επιστροφή</el-button>
    </div>
  </el-dialog>
</template>
<script src="./ProductVM.js"></script>
