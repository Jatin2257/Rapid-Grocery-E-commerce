package com.rapid.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralImp<E extends Object> {

	// Get the only single column value
	public String getSingleColumnValue(String hql, SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		String value = (String) session.createQuery(hql).uniqueResult()
				.toString();
		return value;
	}

	// Get the current Date
	public Date getCurrentDate(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("SELECT now()");
		return (Date) query.uniqueResult();
	}

	public void deleteByHQL(String hql, SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	// Update or Modify the Particular Record
	public void modify(Object entity, SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	// Create or Insert the Record to particular Table
	public Object create(E entity, SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
		Object id = session.save(entity);
		return id;
	}

	// Getting the Record from Particular Id
	public E getById(Class clazz, Serializable entityId,
			SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		E e = (E) session.get(clazz, entityId);

		return e;
	}

	// Getting the Record from Particular Id
	public E loadById(Class clazz, Serializable entityId,
			SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		E e = (E) session.load(clazz, entityId);

		return e;
	}

	// getting list using HQL Query.
	public List<E> getListByHQL(String hql, SessionFactory sessionFactory) {

		Session session = sessionFactory.getCurrentSession();
		List<E> result = null;
		Query query = session.createQuery(hql);
		result = query.list();

		return result;
	}

	// getting list using HQL Query.
	public String getValueByHQL(String hql, SessionFactory sessionFactory) {

		Session session = sessionFactory.getCurrentSession();
		Object object = session.createQuery(hql).uniqueResult();
		if (object == null) {
			return "null";
		} else {
			return object.toString();
		}
	}

	public List<E> getListByCriteria(Class clazz, String tableAndAlias[],
			SimpleExpression simpleExpression[],
			LogicalExpression logicalExpression[], Order order[],
			AggregateProjection aggregateProjection[], Criterion criterion[],
			SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		addCriterion(criteria, criterion);
		createCriteriaAndAlias(criteria, tableAndAlias);
		addSimpleExpression(criteria, simpleExpression);
		addLogicalExpression(criteria, logicalExpression);
		setAggregateProjection(criteria, aggregateProjection);
		addOrder(criteria, order);

		return criteria.list();
	}

	private void addSimpleExpression(Criteria criteria,
			SimpleExpression simpleExpression[]) {
		if (simpleExpression != null) {
			for (int i = 0; i < simpleExpression.length; i++) {
				criteria.add(simpleExpression[i]);
			}
		}
	}

	private void addLogicalExpression(Criteria criteria,
			LogicalExpression logicalExpression[]) {
		if (logicalExpression != null) {
			for (int i = 0; i < logicalExpression.length; i++) {
				criteria.add(logicalExpression[i]);
			}
		}
	}

	private void addCriterion(Criteria criteria, Criterion criterion[]) {
		if (criterion != null) {
			for (int i = 0; i < criterion.length; i++) {
				criteria.add(criterion[i]);
			}
		}
	}

	private void addOrder(Criteria criteria, Order order[]) {
		if (order != null) {
			for (int i = 0; i < order.length; i++) {
				criteria.addOrder(order[i]);
			}
		}
	}

	private void setAggregateProjection(Criteria criteria,
			AggregateProjection aggregateProjection[]) {
		if (aggregateProjection != null) {
			for (int i = 0; i < aggregateProjection.length; i++) {

				criteria.setProjection(aggregateProjection[i]);
			}
		}
	}

	public void createCriteriaAndAlias(Criteria criteria,
			String tableAndAlias[]) {
		if (tableAndAlias != null) {
			for (int i = 0; i < tableAndAlias.length;) {
				criteria.createCriteria(tableAndAlias[i++], tableAndAlias[i++]);
			}
		}
	}

	public static boolean dateValidationForRide(String date, String time,
			int hour) {
		boolean valid = false;
		try {
			Date d = new Date();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			String expectedDate = date + " ";
			String expectedTime = time;
			Date d1 = format.parse(expectedDate + expectedTime);

			final long ONE_MINUTE_IN_MILLIS = 60000;
			long t = d.getTime();
			int minute = hour * 60;
			Date afterAddingTenMins = new Date(t
					+ (minute * ONE_MINUTE_IN_MILLIS));
			valid = d1.after(afterAddingTenMins);
		} catch (Exception e) {
		}

		return valid;
	}

	public static String convertUTCDate(String date, String time) {
		String returnDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date bookDate = sdf.parse(date + " " + time + ":00");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			returnDate = sdf.format(bookDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnDate;
	}

	public static Date convertTodayDateToUTCDate() {
		Date returnDate = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			returnDate = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnDate;
	}

	public static boolean futureDateValidation(String date, String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date bookDate = sdf.parse(date + " " + time + ":00");
			String journyDate = sdf.format(bookDate);

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date returnDate = sdf.parse(sdf1.format(new Date()));

			Calendar c = Calendar.getInstance();
			c.setTime(returnDate);
			c.add(Calendar.DATE, 30);
			Date oneMonthAfter = sdf.parse(sdf.format(c.getTime()));

			return oneMonthAfter.after(sdf.parse(journyDate));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static Date getClientTimeFromUTC(Date utcDate) {
		String clientTimezone = "IST";
		if (utcDate == null)
			return null;
		else {
			long utcTimeinMilliSeconds = utcDate.getTime();
			TimeZone timezone = TimeZone.getTimeZone(clientTimezone); // timezone
			long timezoneOffset = timezone.getOffset(utcTimeinMilliSeconds);
			Date tmpDate = new Date(utcTimeinMilliSeconds + timezoneOffset);
			return tmpDate;
		}
	}

	public static Date getUTCFromClientDate(Date clientDate) throws Exception {
		String timeZoneID = "IST";
		if (clientDate == null)
			return null;
		else {
			long clientTimeinMilliSeconds = clientDate.getTime();
			long clientTimezoneoffset = TimeZone.getTimeZone(timeZoneID)
					.getOffset(clientTimeinMilliSeconds);
			Date utcDate = new Date(clientTimeinMilliSeconds
					- clientTimezoneoffset);
			return utcDate;
		}
	}

	public static long getDateDiffInMinutes(Date date1, Date date2) {
		long diffInMillies = date1.getTime() - date2.getTime();
		return diffInMillies / 60000;

	}
}
