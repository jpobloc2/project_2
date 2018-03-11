package com.revature.services;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Reimbursement;
import com.revature.entities.Users;
import com.revature.repo.ReimbRepo;
import com.revature.repo.StatusRepo;
import com.revature.repo.UsersRepo;

import oracle.net.aso.i;

@Service
public class ReimbService implements ReimbServiceInterface {
	@Autowired
	private ReimbRepo reimbRepo;
	@Autowired
	private AuthenticationService as;
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private StatusRepo statusRepo;

	@Override
	public List<Reimbursement> findAll() {
		return reimbRepo.findAll();
	}

	@Override
	public Set<Reimbursement> findByuserid(int author_id) {
		Users u = usersRepo.findById(author_id).get();
		Set<Reimbursement> usersReimbs = u.getReimbursements();
		if (u.getRole().getUserRole().equals("Manager")) {
			Set<Users> suboordinates = u.getSubordinates();
			for (Users sub: suboordinates) {
				usersReimbs.addAll(sub.getReimbursements());
			}
		} else {
			usersReimbs = u.getReimbursements();
		}
		return usersReimbs;
	}

	@Override
	public Reimbursement submitReimb(Reimbursement r) {
		return reimbRepo.save(r);
	}

	@Override
	public Reimbursement resolve(int tsid, String resolution, int userid) {
		Reimbursement ret = null;
		Users u = as.validateUser(userid);
		boolean isCorrectManager = validateManagerDomain(tsid, u);
		if (isCorrectManager) {
			Reimbursement rs = reimbRepo.findById(tsid).get();
			System.out.println(rs);
			rs.setReimbResolver(u);
			rs.setReimbResolved(new Timestamp(System.currentTimeMillis()));
			rs.setReimbStatus(statusRepo.findByStatus(resolution));
			System.out.println(rs);
			ret = reimbRepo.save(rs);
			System.out.println(ret);
		}
		return ret;
	}

	public boolean validateManagerDomain(int tsid, Users u) {
		Users user = reimbRepo.findById(tsid).get().getReimbAuthor();
		return u.getSubordinates().contains(user);
	}

}
