package com.andev.repository;

import com.andev.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity,Long> , JpaSpecificationExecutor<UserEntity> {
    // exp: find userName vs userEmail
    // findByUserNameAndUserEmail
    // UserNameAndUserEmail
    // userNameAnduserEmail
    // where userName = ?1  and userEmail = ?1

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
    UserEntity findByUserName(String userName);

    /**
     *  WHERE userName like %?
     * */
    List<UserEntity> findByUserNameStartingWith(String userName);

    /**
     *  WHERE userName like ?%
     * */
    List<UserEntity> findByUserNameEndingWith(String userName);

    /**
     *  WHERE id < 1
     * */
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    // Use RAW JPQL (have parameter) (option 1)
    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    // Use RAW JPQL (have parameter) (option 2)
    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName,@Param("userEmail") String userEmail);

    /**
     * UPDATE
     */
    @Modifying
    @Query("UPDATE UserEntity u  SET u.userName = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // Native query
    /**
     * get count user use native query
     * */
    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();
}