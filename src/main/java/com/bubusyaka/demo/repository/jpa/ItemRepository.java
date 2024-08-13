package com.bubusyaka.demo.repository.jpa;

import com.bubusyaka.demo.model.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    @Query(value = "SELECT * from item i where i.\"name\" = :name", nativeQuery = true)
    List<ItemEntity> findByName(@Param("name") String name);

    @Query(value = """
            SELECT i.id, i.name, i.price, i.provider_id from item i 
                join providers p on i.provider_id = p.id 
                     where p.provider_city in (:providerCity)
                         """, nativeQuery = true)
    List<ItemEntity>findItemsByProviderCityInNative(List<String> providerCity);
}
