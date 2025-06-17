package ma.enaa.deliverymatchs.Repo;

import ma.enaa.deliverymatchs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
