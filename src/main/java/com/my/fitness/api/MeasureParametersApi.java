package com.my.fitness.api;

import com.my.fitness.converters.impl.MeasureParametersEntityConverter;
import com.my.fitness.dto.MeasureParametersEntityDto;
import com.my.fitness.entities.MeasureParametersEntity;
import com.my.fitness.services.MeasureParametersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Measure parameters api controller
 */
@Api(description = "Measure parameters API")
@RestController
@RequestMapping(ApiConfiguration.ROOT + "/measure_parameters")
public class MeasureParametersApi {

    /**
     * Measure parameters service
     */
    @Autowired
    private MeasureParametersService measureParametersService;

    /**
     * Measure parameters entity converter
     */
    @Autowired
    private MeasureParametersEntityConverter measureParametersEntityConverter;

    /**
     * Get measure parameters
     * @param accountUUID Account uuid
     * @param fromDate From date
     * @param toDate To date
     * @return List of measure parameters
     */
    @ApiOperation(value = "Get measure parameters by account UUID")
    @RequestMapping(method = RequestMethod.GET, value = "/account/{accountUUID}")
    public List<MeasureParametersEntityDto> getMeasureParameters(@PathVariable String accountUUID,
                                                           @RequestParam @DateTimeFormat(pattern = "dd-MM-YYYY") Date fromDate,
                                                           @RequestParam @DateTimeFormat(pattern = "dd-MM-YYYY") Date toDate) {
        if (accountUUID == null) {
            return null;
        }
        List<MeasureParametersEntity> measureParameters = measureParametersService.getMeasureParametersByDateRange(fromDate, toDate, accountUUID);
        return measureParametersEntityConverter.convertAll(measureParameters);
    }

}
