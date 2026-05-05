package re.cntt4.session14_demo.repository;

public interface TransantionRepository {

    // chuyen tien
    void bankingMony(Long sendeerId , Long receiveId , Double amount);

    // nap / rut giup tien
    void reachangeMone(Long receiveId , Double amount);


}
