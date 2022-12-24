  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 2, message="User name must be at least 2 characters")
  private String userName;

  @Email
  private String email;

  @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

  // One To Many
  @OneToMany(mappedBy="donor", fetch = FetchType.LAZY)
  private List<Donation> donatedItems; // joined donations

