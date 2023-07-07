Sample json file was retrieved from a pod running on OCP NPRD with a curl request to
http://apgcrpmngdvip.uat.corp.telenet.be:19088/api/v1/billingManagement/billingAccount/msisdn/0469213586

To modify the data, this command was used:
curl -X PUT  -H 'Content-Type: application/json' -v "http://apgcrpmngdvip.uat.corp.telenet.be:19088/api/v1/billingManagement/billingAccount/9166440568213618016" -d '{same json as from the get response}'
