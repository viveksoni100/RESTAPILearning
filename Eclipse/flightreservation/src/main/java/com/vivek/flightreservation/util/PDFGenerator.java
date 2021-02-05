package com.vivek.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vivek.flightreservation.entities.Reservation;

@Component
public class PDFGenerator {

	public void generateItinerary(Reservation reservation, String filePath) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		// TODO Auto-generated method stub

		PdfPCell cell;

		PdfPTable table = new PdfPTable(2);

		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		// and so on

		return null;
	}
}
