package alex.vis.springbootmongodb.repository;

import alex.vis.springbootmongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Наследуемся от монгорепозитори чтобы получить базовую функциональность по аналогии с JpaRepository
@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    //Вместо хардкодинга в Query мы добавляем placeholder для параметров
    //Query используется как поисковик
    @Query("{'name':  ?0}")
    Optional<Expense> findByName(String name);

// Еще можно так
//    @Query("{'name':  ?0, 'amount': ?1}")
//    Optional<Expense> findByName(String name, String amount);
}
