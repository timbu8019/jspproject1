package com.insurance.register;

public class User {
		private int id;
		private String name;
		private String password;
		private String role;
		public User()
		{
			
		}
		public User(int id,String name,String password,String role) 
		{
			this.id=id;
			this.password=password;
			this.name=name;
			this.role=role;
		}
		
		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id=id;
		}
		public String getPassword()
		{
			return password;
		}
		public void setPassword(String password)
		{
			this.password=password;;
		}
		
		public String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name=name;
		}
		
		public String getRole()
		{
			return role;
		}
		public void setRole(String role)
		{
			this.role=role;
		}
	
}
