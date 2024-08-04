package com.Rapid.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.FeedbackTableBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.model.FeedbackTable;
import com.Rapid.service.FeedbackService;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@RequestMapping(value="/feedback_list", method = RequestMethod.GET)
	public ModelAndView viewAllFeedbacks() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<FeedbackTable> list = feedbackService.listFeedbacks();		
		model.put("feedbacks", prepareListofBean(list));
		return new ModelAndView("feedback_list", model);
	}
																		
	private List<FeedbackTableBean> prepareListofBean(List<FeedbackTable> feed) {
		List<FeedbackTableBean> beans = null;
		if(feed != null && !feed.isEmpty()){
			beans = new ArrayList<FeedbackTableBean>();
			FeedbackTableBean bean = null;
			Iterator itr = feed.iterator();
			while (itr.hasNext()) {
				bean = new FeedbackTableBean();
				Object[] obj = (Object[]) itr.next();
				bean.setFeedbackId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setFeedbackMessage(String.valueOf(obj[1]));
				
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			     
			      Date date=null;
				try {
					date = formatter.parse(String.valueOf(obj[2]));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			      
				
				bean.setFeedbackDate(date);
				bean.setUserMasterFirstName(String.valueOf(obj[5]));
				bean.setUserMasterLastName(String.valueOf(obj[6]));
				

				beans.add(bean);
			}
		}
		return beans;
	}
}
