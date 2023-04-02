//package com.codingfist.burninghouseauth.domain.user.repository;
//
//
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//
//
//
//@Repository
//public class UserRepositorySupport extends QuerydslRepositorySupport {
//
//    private JPAQueryFactory queryFactory;
//
//    public UserRepositorySupport(JPAQueryFactory queryFactory) {
//        super(User.class);
//        this.queryFactory = queryFactory;
//    }
//
//
//    public void existByUsername(String userName) {
//        User exist=queryFactory.selectFrom(user)
//                .where(user.userName.eq(userName))
//                .fetchOne();
//        if (exist != null){
//            throw new UsernameDuplicatedException(userName);
//        }
//    }
//
//    public User findByUsername(String userName) {
//        User user1= queryFactory.selectFrom(user)
//                .where(user.userName.eq(userName))
//                .fetchOne();
//        if (user1==null){
//            throw new UserNotFoundException(userName);
//        }
//        user1.invalid();
//
//        return user1;
//    }
//
//    public User findById(UUID userId) {
//
//        User foundUser= queryFactory.selectFrom(user)
//                .where(user.id.eq(userId)).fetchOne();
//
//        if (foundUser==null){
//            throw new UserNotFoundException(userId.toString());
//        }
//        foundUser.invalid();
//
//        return foundUser;
//    }
//    public User findUserById(UUID userId) {
//
//        User foundUser= queryFactory.selectFrom(user)
//                .where(user.id.eq(userId)).fetchOne();
//
//        if (foundUser==null){
//            throw new UserNotFoundException(userId.toString());
//        }
//
//
//        return foundUser;
//    }
//
//    public List<User> findAll(String userType, String query, DateDTO dateDTO,UUID userId) {
//        return queryFactory.selectFrom(user)
//                .where(user.id.isNotNull()
//                        .and(userTypeCondition(userType,userId))
//                        .and(searchQuery(query))
//                        .and(dateQuery(dateDTO)))
//                .fetch();
//    }
//
//    private BooleanExpression dateQuery(DateDTO dateDTO) {
//        if (dateDTO.getStartedDate()==null){
//            return null;
//        }
//        if (dateDTO.getEndedDate()==null){
//            return null;
//        }
//
//        return user.createdDate.between(dateDTO.getStartedDate(),dateDTO.getEndedDate());
//    }
//
//    private BooleanExpression searchQuery(String query) {
//        if(query==null){
//            return null;
//        }
//        return user.name.contains(query)
//                .or(user.company.name.contains(query)
//                        .or(user.userName.contains(query)));
//    }
//
//    private BooleanExpression userTypeCondition(String userType,UUID userId) {
//        if(userType==null){
//            return null;
//        }
//        if (userType.equals("agent")){
//            return user.userType.eq(UserType.AGENT)
//                    .and(user.roles.isNotEmpty());
//        }
//        if (userType.equals("manufacturer")){
//            return user.userType.eq(UserType.MANUFACTURER)
//                    .and(user.roles.isNotEmpty());
//        }
//        if (userType.equals("unapproved")){
//            return user.roles.isEmpty();
//        }
//        return null;
//    }
//
//    public List<User> findByCompanyId(Long companyId) {
//        List<User> users=queryFactory.selectFrom(user)
//                .where(user.id.isNotNull()
//                        .and(user.company.id.eq(companyId))
//                        .and(didInvalid()))
//                .fetch();
//        return users.stream().filter(user1 -> user1.getDeletedDate()==null).collect(Collectors.toList());
//
//    }
//
//    private BooleanExpression didInvalid() {
//        return user.didAddress.isNotNull()
//                .and(user.didAddress.isNotEmpty())
//                .and(user.deletedDate.isNull());
//    }
//
//    public void checkUserEmail(String inputEmail) {
//        User findUser=queryFactory.selectFrom(user)
//                .where(user.userEmail.eq(inputEmail)).fetchOne();
//
//        if (findUser!=null){
//            throw new UserEmailDuplicatedException(inputEmail);
//        }
//
//    }
//
//
//    public User findByUserEmail(String userEmail) {
//        User findUser=queryFactory.selectFrom(user)
//                .where(user.userEmail.eq(userEmail)).fetchOne();
//        if (findUser==null){
//            throw new UserNotFoundException(userEmail);
//        }
//        return findUser;
//    }
//}
