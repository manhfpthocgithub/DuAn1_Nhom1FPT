/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author admin
 */
public abstract class DuAn1DAO<Entity,Key> {
   abstract public void insert(Entity entity);
   abstract public void update(Entity entity);
   abstract public List<Entity> selectAll();
   abstract public Entity selectById(Key key);
   abstract protected List<Entity> selectBySql(String sql,Object...args);
}

