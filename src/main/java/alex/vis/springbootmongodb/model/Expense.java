package alex.vis.springbootmongodb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
//Мапит обьект к документу монго дб с именем expense
@Document("expense")
public class Expense {
    //Показывает что это айди документа
    @Id
    private String id;
    //Тут мы указали что поле в документе будет именоваться name вместо expenseName
    @Field(name = "name")
    //Тут мы указали что мы создаем индекс по уникальному имени
    @Indexed(unique = true)
    private String expenseName;
    @Field(name = "category")
    private ExpenseCategory expenseCategory;
    @Field(name = "amount")
    private BigDecimal expenseAmount;
}
