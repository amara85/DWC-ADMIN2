/**
 * 
 */
package com.ensat.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.ensat.forms.reports.Rep1Form;
import com.ensat.forms.reports.Rep2Form;
import com.ensat.forms.reports.Rep3Form;


/**
 * @author Amara Ghoufa
 * Cette classe permet la géneration des rapports
 */
@Controller
@RequestMapping(value = "/app1/rapports")
public class ReportsController {

	@Autowired
	private DataSource dbsoruce;

	private Connection connection;
	
	/**
     * retourner vue génerer recettes moyennes pour une destination
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "anal-rect-dest", method = RequestMethod.GET)
    public String getRapportAnalyseRecettesDestinationVue(Model model) {
    	model.addAttribute("rep1form", new Rep1Form());
        return "app1/rapports/rep-rect-dest";
    }


	/*
	 * Permet la génération des rapports d'analyse des recettes pour une destination
	 */
	@RequestMapping(value = "anal-rect-dest", method = RequestMethod.POST)
	public String getRapportAnalyseRecettesDestination(Model model, HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("rep1form") Rep1Form rep1form, BindingResult result) {
		
		
		if (result.hasErrors()) {
			return "app1/rapports/rep-rect-dest";
		}
		
		else{

		Map<String, Object> params = new HashMap<>();
		params.put("Destination", rep1form.getDestination());
		params.put("Dest", rep1form.getDestination());
		params.put("S1", rep1form.getP1());
		params.put("S2", rep1form.getP2());
		params.put("date11", rep1form.getDate11());
		params.put("date12", rep1form.getDate12());
		params.put("date21", rep1form.getDate21());
		params.put("date22", rep1form.getDate22());
		
        byte[] bytes = null;
		
		try {
			connection = dbsoruce.getConnection();
			InputStream jasperStream = this.getClass().getResourceAsStream("/rapports/rep1/Analyse recettes.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(jasperStream);
			bytes = JasperRunManager.runReportToPdf(jasperReport, params,connection);
			connection.close();
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return null;

		}

	}
	
	
	/**
     * retourner vue génerer recettes moyennes pour des vols avec un NTU
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "anal-rect-ntu", method = RequestMethod.GET)
    public String getRapportAnalyseRecettesNtuVue(Model model) {
    	model.addAttribute("rep2form", new Rep2Form());
        return "app1/rapports/rep-rect-ntu";
    }


	/*
	 * Permet la génération des rapports d'analyse des recettes pour une destination
	 */
	@RequestMapping(value = "anal-rect-ntu", method = RequestMethod.POST)
	public String getRapportAnalyseRecettesNtu(Model model,HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("rep2form") Rep2Form rep2form, BindingResult result) throws JRException,
			IOException {
		
		
		if (result.hasErrors()) {
			return "app1/rapports/rep-rect-ntu";
		}
		
		else{

		InputStream jasperStream = this.getClass().getResourceAsStream(
				"/rapports/rep2/Analyse recettes.jasper");
		Map<String, Object> params = new HashMap<>();
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(jasperStream);

		params.put("NTU2", rep2form.getNTU());
		params.put("Nvol11", rep2form.getNvol11());
		params.put("Nvol12", rep2form.getNvol12());
		params.put("Nvol21", rep2form.getNvol21());
		params.put("Nvol22", rep2form.getNvol22());
		params.put("S1", rep2form.getP1());
		params.put("S2", rep2form.getP2());
		params.put("date11", rep2form.getDate11());
		params.put("date12", rep2form.getDate12());
		params.put("date21", rep2form.getDate21());
		params.put("date22", rep2form.getDate22());

		byte[] bytes = null;
		
		try {
			connection = dbsoruce.getConnection();
			bytes = JasperRunManager.runReportToPdf(jasperReport, params,connection);
			connection.close();
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return null;
		
		}

	}
	
	
	/**
     * retourner vue génerer rapport suivi saison
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "suivi-saison", method = RequestMethod.GET)
    public String getRapportSuiviSaisonVue(Model model) {
    	model.addAttribute("rep3form", new Rep3Form());
        return "app1/rapports/rep-suivi-saison";
    }


	/*
	 * Permet la génération des rapports suivi saison
	 */
	@RequestMapping(value = "suivi-saison", method = RequestMethod.POST)
	public String getRapportSuiviSaison(Model model,HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("rep3form") Rep3Form rep3form, BindingResult result) throws JRException,
			IOException {
		
		
		if (result.hasErrors()) {
			return "app1/rapports/rep-suivi-saison";
		}
		
		else{
			
			String[] rep = new String[6];

			rep[0] = "/rapports/rep3/Rapport suivi saison Page 1.jrxml";
			rep[1] = "/rapports/rep3/Rapport suivi saison Page 2.jrxml";
			rep[2] = "/rapports/rep3/Rapport suivi saison Page 3.jrxml";
			rep[3] = "/rapports/rep3/Rapport suivi saison Page 4.jrxml";
			rep[4] = "/rapports/rep3/Rapport suivi saison Page 5.jrxml";
			rep[5] = "/rapports/rep3/Rapport suivi saison Page 6.jrxml";

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("S1", rep3form.getS1());
			parameters.put("S2", rep3form.getS2());
			parameters.put("S3", rep3form.getS3());
			parameters.put("date1", rep3form.getDate1());
			parameters.put("date2", rep3form.getDate2());
			parameters.put("date3", rep3form.getDate3());

			List<JasperPrint> jprintlist = new ArrayList<JasperPrint>();
			JasperReport jasperReport;

			for (int i = 0; i < rep.length; i++) {
				try {

					connection = dbsoruce.getConnection();
					jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream(rep[i]));
					JasperPrint jprint = JasperFillManager.fillReport(jasperReport,
							parameters, connection);

					jprintlist.add(jprint);
					connection.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			JRPdfExporter exporter = new JRPdfExporter();

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jprintlist);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
			byte[] bytes = out.toByteArray();
			
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
		
		    return null;
		
		}

	}


	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}