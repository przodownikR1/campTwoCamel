package pl.java.scalatech.camel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CurrentService {
    @WebMethod(operationName="byCode")
    String getMultiplierByCode(@WebParam(name="code") String currencyCode);    
}
