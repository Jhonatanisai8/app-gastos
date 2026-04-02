package com.isai.app.service;

import com.isai.app.models.dtos.req.GastoRequest;
import com.isai.app.models.dtos.res.GastoResponse;

public interface GastoService {
    
    GastoResponse guardarGasto(GastoRequest gastoRequest);

}
