package com.example.nikki.model.diary;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class service {
    private final Repository repo;
    @Autowired
    public service(Repository repo){
        this.repo=repo;
    }

    public void EntityService(Entity entity){

        repo.save(entity);
    }


    public List<Entity> entityFindAll() {
        Iterable<Entity> entitiesIterable = repo.findAll();

        // デバッグ：entitiesIterable の内容を確認
        entitiesIterable.forEach(entity -> System.out.println("Entity: " + entity));

        // IterableをListに変換する
        List<Entity> entities = new ArrayList<>();
        entitiesIterable.forEach(entities::add);

        // デバッグ：entities リストの内容を確認
        entities.forEach(entity -> System.out.println("Entity in List: " + entity));

        // もしnullが返ってくる可能性があるなら、nullチェックを行う
        if (entities == null) {
            System.out.println("entities is null");
            // エラーハンドリングまたは適切な処理を行う
        }

        return entities;
    }
    public void delete(Integer id){
        try {
            repo.deleteById(id);


        }catch(EmptyStackException e){
            e.printStackTrace();

        }
    }
    public List<Entity> entityFindByLimit(){
        return repo.findFirst10ByOrderByDateDesc();
    }
    public Entity findId(Integer id){
        Optional<Entity> optionalEntity = repo.findById(id);
        return optionalEntity.orElse(null);
    }
    @Transactional
    public void Update(Entity entity){
        repo.save(entity);
    }

}
