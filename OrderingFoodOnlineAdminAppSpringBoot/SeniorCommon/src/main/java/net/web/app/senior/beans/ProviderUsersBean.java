package net.web.app.senior.beans;

public class ProviderUsersBean {

    private Integer id;
    private BranchBean branch;
    private ProviderBean provider;
    private String username;
    private String password;
    private byte active;

    public ProviderUsersBean(BranchBean branch, ProviderBean provider, String username, String password, byte active) {
        this.branch = branch;
        this.provider = provider;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public ProviderUsersBean(Integer id, BranchBean branch, ProviderBean provider, String username, String password, byte active) {
        this.id = id;
        this.branch = branch;
        this.provider = provider;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BranchBean getBranch() {
        return branch;
    }

    public void setBranch(BranchBean branch) {
        this.branch = branch;
    }

    public ProviderBean getProvider() {
        return provider;
    }

    public void setProvider(ProviderBean provider) {
        this.provider = provider;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public ProviderUsersBean() {
    }
}
