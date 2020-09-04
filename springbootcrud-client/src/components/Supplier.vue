<template>
  <el-dialog
    type="warning"
    title="Διαχείριση Χρήστη"
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
      <el-form ref="supplierForm" :model="supplier" :rules="rules" label-position="top">
        <el-row :gutter="20">
          <!-- LEFT COLUMN -->
          <el-col :span="12">
            <el-form-item label="Εισάγετε το όνομα της εταιρειας" prop="companyName">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.companyName"
                placeholder="Όνομα Εταιρειας"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε το όνομα" prop="firstName">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.firstName"
                placeholder="Όνομα"
                autocomplete="firstName"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε το επιθέτο" prop="lastName">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.lastName"
                placeholder="deytero όνομα"
                autocomplete="lastName"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε το VATNumber" prop="vatNumber">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.vatNumber"
                placeholder="VATNumber"
                autocomplete="vatNumber"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε το irsOffice" prop="irsOffice">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.irsOffice"
                placeholder="irsOffice"
                autocomplete="irsOffice"
              ></el-input>
            </el-form-item>
          </el-col>
          <!-- RIGHT COLUMN -->
          <el-col :span="12">
            <el-form-item label="Εισάγετε τη Διευθυνση" prop="address">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.address"
                placeholder="Διευθυνση"
                autocomplete="address"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε το zip Code" prop="zipCode">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.zipCode"
                placeholder="zip Code"
                autocomplete="zipCode"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε τη πολη" prop="city">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.city"
                placeholder="πολη"
                autocomplete="city"
              ></el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε τη χωρα" prop="country">
              <el-input
                prefix-icon="fa fa-user"
                v-model="supplier.country"
                placeholder="χωρα"
                autocomplete="country"
              ></el-input>
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
<script src="./SupplierVM.js"></script>
