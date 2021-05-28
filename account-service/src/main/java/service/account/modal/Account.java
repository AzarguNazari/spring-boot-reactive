package service.account.modal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Account {

    @Id
    private String id;
    private String number;
    private String customerId;
    private int amount;
}
