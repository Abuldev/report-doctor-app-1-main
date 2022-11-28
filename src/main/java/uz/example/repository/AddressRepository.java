package uz.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.entity.Address;

/**
 * Me: muhammadqodir
 * Project: SpringMyProject/IntelliJ IDEA
 * Date:Mon 24/10/22 00:51
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
