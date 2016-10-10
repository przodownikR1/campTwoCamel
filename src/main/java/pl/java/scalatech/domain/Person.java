package pl.java.scalatech.domain;



import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@CsvRecord(separator = ",", crlf = "\n",skipFirstLine=true)
public class Person {

    @DataField(pos = 1)
    private String clientNr;

    @DataField(pos = 2)
    private String firstName;

    @DataField(pos = 3)
    private String lastName;

    @DataField(pos = 4) 
    private String orderDate;
}