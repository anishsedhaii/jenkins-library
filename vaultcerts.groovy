def call(String VAULT_TOKEN, String VAULT_SERVER, String VAULT_PATH){
   def workingDir = "${WORKSPACE}"
   sh "curl --header "X-Vault-Token: $VAULT_TOKEN" --request GET https://${VAULT_SERVER}/v1/${VAULT_PATH} | jq -r ".data.cert" > ssl/STAR_khalti_com_np_bundle.pem"
   sh "curl --header "X-Vault-Token: $VAULT_TOKEN" --request GET https://${VAULT_SERVER}/v1/${VAULT_PATH} | jq -r ".data.privkey" > ssl/STAR_khalti_com_np_privkey.pem"
   return workingDir
}