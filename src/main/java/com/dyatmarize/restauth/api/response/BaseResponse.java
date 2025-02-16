package com.dyatmarize.restauth.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class BaseResponse {
    private final Boolean success;
    private final String type;
    private final Object data;
}
