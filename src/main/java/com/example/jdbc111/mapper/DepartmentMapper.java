package com.example.jdbc111.mapper;

import com.example.jdbc111.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Select("select * from department where id = #{id} and departmentName = #{name}")
    public Department getDeptByIdAndName(@Param("id") Integer id, @Param("name") String name);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Insert("insert into department (departmentName) values (#{departmentName})")
    public int insertDept(Department department);

    @Update("update  department set department = #{departmentName} where id =  values (#{id})")
    public int updateDept(Department department);

}
