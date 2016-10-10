package pl.java.scalatech.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@CsvRecord(separator = ",", crlf = "\n",skipFirstLine=true)
public class User {
    @DataField(pos = 1,trim=true)
    @Id @GeneratedValue
    private Long id = 0l;
    @DataField(pos = 2,trim=true)
    private String email;
    @DataField(pos = 3,trim=true)
    private String name;
    @DataField(pos = 4,trim=true)
    private String creditCardType;
    @DataField(pos = 5,trim=true)
    private String login;
    @DataField(pos = 6,trim=true)
    private BigDecimal salary;
    @DataField(pos = 7,trim=true)
    private Currency currency;
    @DataField(pos = 8,trim=true)
    private Position position;
    @DataField(pos = 9,trim=true)
    private String city;
    @DataField(pos = 10,trim=true)
    private String country;
    @DataField(pos = 11,trim=true)
    private String creditCard;
}