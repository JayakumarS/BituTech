package com.bitutech.gatePass;

import java.util.List;

public interface GatePassDao {
	
	GatePassResultBean save(GatePassBean bean) throws Exception;
	
	List<GatePassBean> getOrganizationList() throws Exception;
	
	List<GatePassBean> getLocationList() throws Exception;

	GatePassResultBean edit(Integer itemMaster) throws Exception;

	GatePassResultBean update(GatePassBean itemMaster) throws Exception;

	GatePassResultBean delete(Integer itemId) throws Exception;

}
