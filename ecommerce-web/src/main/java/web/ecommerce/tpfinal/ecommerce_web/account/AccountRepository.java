package web.ecommerce.tpfinal.ecommerce_web.account;

import java.util.List;

import javax.persistence.*;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;


@Repository
@Transactional(readOnly = true)
public class AccountRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		entityManager.persist(account);
		return account;
	}
	
	public Account findByEmail(String email) {
		try {
			return entityManager.createNamedQuery(Account.FIND_BY_EMAIL, Account.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	public List<Account> getAll() {
		TypedQuery<Account> q = entityManager.createQuery("select a from Account a", Account.class);
		List<Account> accounts = q.getResultList();
		LOG.info("Se obtuvieron {} usuarios", accounts.size());

		return accounts;
	}
	public Account getU(int id){
		Account account=null;
		account=entityManager.find(Account.class, id);
		return account;
	}
	public void deleteU(int id){
		Account account=getU(id);
		entityManager.remove(account);
		entityManager.flush();
	}
	public void saveU(Account account){
		entityManager.refresh(account);
	}

	
	
}
