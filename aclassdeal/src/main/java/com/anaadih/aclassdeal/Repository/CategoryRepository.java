package com.anaadih.aclassdeal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.CategoryModel;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<CategoryModel,String> {

	@Query( nativeQuery=true,value="select  c.catCode,c.catName count(p.category) as Total from CategoryModel c left join ProductModel p on c.catCode = p.category where p.isInUse = '1' and p.isReported ='0' and p.isApproved = '1'  group by c.catCode")
	List<CategoryModel> findByjoinQuery();
}
//