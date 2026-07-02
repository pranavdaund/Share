package dao;

import pojos.Address;

public interface IAddressDao {

	String linkAddressToStudent(int studentId, Address address);

}
