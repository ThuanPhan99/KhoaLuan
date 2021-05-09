package com.khosach.payment.pay.processor.notallinone;

import com.google.gson.Gson;
import com.khosach.payment.pay.models.TransactionQueryRequest;
import com.khosach.payment.pay.models.TransactionQueryResponse;
import com.khosach.payment.shared.constants.Parameter;
import com.khosach.payment.shared.exception.MoMoException;
import com.khosach.payment.shared.sharedmodels.AbstractProcess;
import com.khosach.payment.shared.sharedmodels.Environment;
import com.khosach.payment.shared.sharedmodels.HttpResponse;
import com.khosach.payment.shared.utils.Encoder;
import com.khosach.payment.shared.utils.LogUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TransactionQuery extends AbstractProcess<TransactionQueryRequest, TransactionQueryResponse> {

    public TransactionQuery(Environment environment) {
        super(environment);
    }

    public static TransactionQueryResponse process(Environment env, String partnerRefId, String requestId, String publicKey, String momoTransId, double version) throws Exception {
        try {
            TransactionQuery transactionQuery = new TransactionQuery(env);

            TransactionQueryRequest transactionQueryRequest = transactionQuery.createTransactionQueryRequest(partnerRefId, requestId, publicKey, momoTransId, version);
            TransactionQueryResponse transactionQueryResponse = transactionQuery.execute(transactionQueryRequest);
            return transactionQueryResponse;

        } catch (Exception e) {
            LogUtils.error("[TransactionQueryProcess] "+ e);
        }
        return null;
    }

    @Override
    public TransactionQueryResponse execute(TransactionQueryRequest request) throws MoMoException {
        try {
            String payload = getGson().toJson(request, TransactionQueryRequest.class);

            HttpResponse response = execute.sendToMoMo(environment.getMomoEndpoint(), payload);
            if (response.getStatus() != 200) {
                throw new MoMoException("[TransactionQueryResponse] [" + request.getPartnerRefId() + "] -> Error API");
            }

            TransactionQueryResponse transactionQueryResponse = getGson().fromJson(response.getData(), TransactionQueryResponse.class);

            return transactionQueryResponse;
        } catch (Exception e) {
            LogUtils.error("[TransactionQueryResponse] "+ e);
        }
        return null;
    }

    public TransactionQueryRequest createTransactionQueryRequest(String partnerRefId, String requestId, String publicKey, String momoTransId, double version) {

        try {

            Map<String, Object> rawData = new HashMap<>();
            rawData.put(Parameter.PARTNER_REF_ID, partnerRefId);
            rawData.put(Parameter.PARTNER_CODE, partnerInfo.getPartnerCode());
            rawData.put(Parameter.REQUEST_ID, requestId);
            rawData.put(Parameter.MOMO_TRANS_ID, momoTransId);

            Gson gson = new Gson();
            String jsonStr = gson.toJson(rawData);
            byte[] testByte = jsonStr.getBytes(StandardCharsets.UTF_8);
            String hashRSA = Encoder.encryptRSA(testByte, publicKey);

            LogUtils.debug("[TransactionQueryRequest] rawData: " + rawData + ", [Signature] -> " + hashRSA);

            return new TransactionQueryRequest(partnerInfo.getPartnerCode(),partnerRefId,version,hashRSA,momoTransId);

        } catch (Exception e) {
            LogUtils.error("[TransactionQueryRequest] "+ e);
        }

        return null;
    }


}
