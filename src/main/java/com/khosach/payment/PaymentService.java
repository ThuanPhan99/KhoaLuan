package com.khosach.payment;

import com.google.gson.Gson;
import com.khosach.dto.OrderCartDTO;
import com.khosach.payment.allinone.models.CaptureMoMoResponse;
import com.khosach.payment.allinone.models.QueryStatusTransactionResponse;
import com.khosach.payment.allinone.processor.allinone.CaptureMoMo;
import com.khosach.payment.allinone.processor.allinone.QueryStatusTransaction;
import com.khosach.payment.shared.sharedmodels.Environment;
import com.khosach.payment.shared.utils.LogUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {



    public CaptureMoMoResponse payMomo (OrderCartDTO orderCartDTO, String orderId)throws Exception {
        LogUtils.init();
        String requestId = String.valueOf(System.currentTimeMillis());
        long amount = orderCartDTO.getTotalMoney();

        String orderInfo = "Pay With MoMo";
        String returnURL = "http://localhost:8080/paymentSuccess";
        String notifyURL = "http://localhost:8080";
        Gson gson = new Gson();
        //convert java object to JSON format
        String extraData = gson.toJson(orderCartDTO);
        String bankCode = "SML";

        Environment environment = Environment.selectEnv("dev", Environment.ProcessType.PAY_GATE);
        CaptureMoMoResponse captureMoMoResponse = CaptureMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, extraData);

        return captureMoMoResponse;
    }

}
