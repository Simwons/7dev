package kr.co.chill.incoming;

import java.util.List;

public class IncomingWrapperList {
	private List<IncomingDTO> incomingDTOList;

	public List<IncomingDTO> getIncomingDTOList() {
		return incomingDTOList;
	}

	public void setIncomingDTOList(List<IncomingDTO> incomingDTOList) {
		this.incomingDTOList = incomingDTOList;
	}

	@Override
	public String toString() {
		return "IncomingWrapperList [incomingDTOList=" + incomingDTOList + "]";
	}


	
}
