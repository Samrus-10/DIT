package sam.rus.rostov.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sam.rus.rostov.entity.Box;
import sam.rus.rostov.entity.Document;
import sam.rus.rostov.entity.Task;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
    @Modifying
    @Query("UPDATE Document d SET d.name = ?2 WHERE d.id = ?1 ")
    int updateNameDocument(long id, String name);

    @Modifying
    @Query("UPDATE Document d SET d.code = ?2 WHERE d.id = ?1 ")
    int updateCodeDocument(long id, String code);

    @Modifying
    @Query("UPDATE Document d SET d.box = ?2 WHERE d.id = ?1 ")
    int updateBoxDocument(long id, Box box);
}
