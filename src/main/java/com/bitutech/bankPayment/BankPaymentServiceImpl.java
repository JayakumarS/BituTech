package com.bitutech.bankPayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class BankPaymentServiceImpl implements BankPaymentService {
		@Autowired
		BankPaymentDao bankPaymentDao;

		@Override
		public BankPaymentResultBean save(BankPaymentBean bean) throws Exception {
			return bankPaymentDao.save(bean);
		}

		@Override
		public List<BankPaymentBean> getList() throws Exception {
			// TODO Auto-generated method stub
			return bankPaymentDao.getList();
		}
		@Override
		public BankPaymentResultBean getVoucherNo() throws Exception {
			// TODO Auto-generated method stub
			return bankPaymentDao.getVoucherNo();
		}
		
		@Override
		public BankPaymentResultBean getVoucherNoList() throws Exception {
			// TODO Auto-generated method stub
			return bankPaymentDao.getVoucherNoList();
		}
		
		@Override
		public BankPaymentResultBean edit(String voucherNo) throws Exception {
			// TODO Auto-generated method stub
			return  bankPaymentDao.edit(voucherNo);
		}

//		@Override
//		public BankPaymentResultBean update( BankPaymentBean bean) throws Exception {
//			// TODO Auto-generated method stub
//			return bankPaymentDao.update(bean);
//		}
		
		@Override
		public BankPaymentResultBean delete(String bean) throws Exception {
			// TODO Auto-generated method stub
			return bankPaymentDao.delete(bean);
		}
	}



