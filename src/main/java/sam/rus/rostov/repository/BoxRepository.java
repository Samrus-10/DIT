package sam.rus.rostov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sam.rus.rostov.entity.Box;

import java.util.Optional;


@Repository
public interface BoxRepository extends CrudRepository<Box, Long> {
    @Modifying
    @Query("UPDATE Box b SET b.name = ?2 WHERE b.id = ?1 ")
    int updateNameBox(long id, String name);

    @Modifying
    @Query("UPDATE Box b SET b.code = ?2 WHERE b.id = ?1 ")
    int updateCodeBox(long id, String code);

    Optional<Box> findByName(String name);
}
