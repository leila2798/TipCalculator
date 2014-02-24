package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	/** Called when the user clicks the Calculate button */
	public void calculateTip(View view) {
		TextView txtErrorMsg = (TextView) findViewById(R.id.txtErrorMsg);
		txtErrorMsg.setVisibility(View.GONE);
		EditText edtBillAmount = (EditText) findViewById(R.id.edtBillAmount);
		try{
			double amount = Double.parseDouble(edtBillAmount.getText().toString());
			CheckBox chkRound = (CheckBox) findViewById(R.id.chkRound);
			boolean round = chkRound.isChecked();
			TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);
			DecimalFormat df = new DecimalFormat("#.##");
			String tipResult = round? Integer.toString((int)Math.round(amount*0.12)): df.format(amount*0.12);
			txtTipResult.setText("Tip: " + tipResult+"$");
		}
		catch (Exception e){
			txtErrorMsg.setVisibility(View.VISIBLE);
			}
	}

}
