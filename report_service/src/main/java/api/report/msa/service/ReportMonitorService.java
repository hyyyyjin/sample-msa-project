package api.report.msa.service;

import api.report.msa.dto.ReportDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReportMonitorService {

    private Logger LOGGER = LoggerFactory.getLogger(ReportMonitorService.class);

    @Value("${server.id}")
    private String SERVER_ID;

    public ReportDto saveReportMonitoring(ReportDto requestParam){

        System.out.println("#####################");
        System.out.println(requestParam.toEntity());

            if(requestParam.getServer_id().equals(SERVER_ID)){
                requestParam.setResponseStatus("OK");
                LOGGER.info(requestParam.toEntity());
            }
            else{
                requestParam.setResponseStatus("INVALID");
                LOGGER.error(requestParam.toEntity());
            }

        return requestParam;

    }

}
