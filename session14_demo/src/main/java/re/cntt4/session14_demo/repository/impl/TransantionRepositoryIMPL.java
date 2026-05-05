package re.cntt4.session14_demo.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import re.cntt4.session14_demo.model.Account;
import re.cntt4.session14_demo.repository.TransantionRepository;

@Repository
@RequiredArgsConstructor
public class TransantionRepositoryIMPL implements TransantionRepository {

    // de tuong tac voi du lieu dung
    private final SessionFactory sessionFactory;
    @Override
    public void bankingMony(Long sendeerId, Long receiveId, Double amount) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        // 1 . tim nguoi gui dua vao id va nguoi nhan

        Account sender = session.get(Account.class,sendeerId);
        Account receive = session.get(Account.class,receiveId);
        // 2 . kiem tra stk nguoi gui
        if (sender.getBalance()< amount){
            System.out.println("khong du tien");
            tx.rollback();
        }else {
            // 3 . cap nhat tien tung tai khoan
            sender.setBalance(sender.getBalance() - amount);
            receive.setBalance(receive.getBalance() + amount);

            // luu lai thong tin khi thay doi
            session.merge(sender);
            session.merge(receive);


            tx.commit();
        }


        // su dung transantion
    }

    @Override
    public void reachangeMone(Long receiveId, Double amount) {

    }
}
