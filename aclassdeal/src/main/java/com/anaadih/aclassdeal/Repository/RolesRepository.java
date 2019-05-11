package com.anaadih.aclassdeal.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.anaadih.aclassdeal.Model.Role;
import com.anaadih.aclassdeal.Model.RoleName;

public interface RolesRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByName(RoleName roleName);
}
