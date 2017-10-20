package jp.co.sacn.dao;

import java.util.List;

import jp.co.sacn.meta.MemberMeta;
import jp.co.sacn.model.Member;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class MemberDao extends DaoBase<Member>{
	protected static MemberMeta meta = new MemberMeta();

    public void creates(List<Member> memberList) {
    	for(Member mb : memberList){
    		create(mb);
    	}
    }
    public Member create(Member member) {
    	Member mb = select(member.getMemberId());
    	if(mb != null){
    		member.setKey(mb.getKey());
    	}

        Transaction tx = Datastore.beginTransaction();
        put(member);
        tx.commit();
        return member;
    }

    public Member select(String memberId) {
        return Datastore.query(meta).filter(meta.memberId.equal(memberId)).asSingle();
    }

    public List<Member> selectMemberList(String groupId) {
        return Datastore.query(meta).filter(meta.groupId.equal(groupId)).asList();
    }

    public List<Member> selectGroupIds(String[] groupIds) {
        return Datastore.query(meta).filter(meta.groupId.in(groupIds)).asList();
    }
}
