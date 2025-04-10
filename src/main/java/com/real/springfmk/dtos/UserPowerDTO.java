package com.real.springfmk.dtos;

public class UserPowerDTO {
	
	    private Long userId;
	    private String userName;
	    private Long powerId;
	    private String powerName;
	    
	    

	    public UserPowerDTO() {
			super();
		}


		public UserPowerDTO(Long userId, String userName, Long powerId, String powerName) {
	        this.userId = userId;
	        this.userName = userName;
	        this.powerId = powerId;
	        this.powerName = powerName;
	    }

	  
	    public Long getUserId() { return userId; }
	    public void setUserId(Long userId) { this.userId = userId; }
	    public String getUserName() { return userName; }
	    public void setUserName(String userName) { this.userName = userName; }
	    public Long getPowerId() { return powerId; }
	    public void setPowerId(Long powerId) { this.powerId = powerId; }
	    public String getPowerName() { return powerName; }
	    public void setPowerName(String powerName) { this.powerName = powerName; }
	
}
