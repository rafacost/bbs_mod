var batchsize=5;
var poundsDME=0;
var poundsLME=0;
var volumeunit="Gallons";
var divOG;
var divFG;
var divABV;
function switchUnitsToUs()
	{
	$(".volumeunit").html("(Gallons)");
	$(".weightunit").html("Pounds");
	volumeunit="Gallons";
	document.calc.txtbatchsize.value="5.5";
	setCookie("bfmetric","",-1);
	updateAll()
}
function switchUnitsToMetric()
	{
	$(".volumeunit").html("(Liters)");
	$(".weightunit").html("Kilograms");
	volumeunit="Liters";
	document.calc.txtbatchsize.value="21";
	setCookie("bfmetric","metric",(365*3));
	updateAll()
}
function setVars()
	{
	batchsize=document.calc.txtbatchsize.value;
	poundsDME=document.calc.txtpoundsdme.value;
	poundsLME=document.calc.txtpoundslme.value;
	divOG=document.getElementById('divOG');
	divFG=document.getElementById('divFG');
	divABV=document.getElementById('divABV')
}
function updateAll()
	{
	if(!checkInput())
		{
		return false
	}
	recalculate()
}
function recalculate()
	{
	if(volumeunit=="Liters")
		{
		batchsize=litersToGallons(batchsize);
		poundsDME=kilogramsToPounds(poundsDME);
		poundsLME=kilogramsToPounds(poundsLME)
	}
	var points=0;
	points=points+(45*poundsDME);
	points=points+(37*poundsLME);
	var attenuation;
	if(document.calc.yeast.value=='low')
		{
		attenuation='0.66'
	}
	if(document.calc.yeast.value=='medium')
		{
		attenuation='0.72'
	}
	if(document.calc.yeast.value=='high')
		{
		attenuation='0.77'
	}
	var OG=((points/batchsize)*0.001)+1;
	var FG=((OG-1)*(1-attenuation))+1;
	var ABV=(OG-FG)*(125*1.05);
	divOG.innerHTML=rounddecimal(OG,3);
	divFG.innerHTML=rounddecimal(FG,3);
	divABV.innerHTML=rounddecimal(ABV,2)+"%"
}
function checkInput()
	{
	setVars();
	if(!isNumber(batchsize))
		{
		alert('Batch Size must be a number');
		return false
	}
	if(!isNumber(poundsDME))
		{
		alert('Pounds DME must be a number');
		return false
	}
	if(!isNumber(poundsLME))
		{
		alert('Pounds LME must be a number');
		return false
	}
	return true
}
function isNumber(s)
	{
	if(s===null)
		{
		return false
	}
	if(s===0)
		{
		return true
	}
	if(s=='')
		{
		return false
	}
	if(isNaN(s))
		{
		return false
	}
	var i;
	for(i=0;
	i<s.length;
	i++)
		{
		var c=s.charAt(i);
		if(!((c>="0")&&(c<="9"))&&c!='.')
			{
			return false
		}
	}
	return true
}
function litersToGallons(liters)
	{
	liters=parseFloat(liters);
	if(isNaN(liters))
		{
		return false
	}
	return 0.264172052*liters
}
function kilogramsToPounds(kg)
	{
	kg=parseFloat(kg);
	if(isNaN(kg))
		{
		return false
	}
	return 2.20462262*kg
}
function rounddecimal(n,places)
	{
	if(n===null)
		{
		return false
	}
	if(n==='')
		{
		return false
	}
	if(isNaN(n))
		{
		return false
	}
	if(places<0)
		{
		return false
	}
	if(places>10)
		{
		return false
	}
	var rounded=Math.round(n*Math.pow(10,places))/Math.pow(10,places);
	var decimalPointPosition=(rounded+"").lastIndexOf(".");
	if(decimalPointPosition==0)
		{
		rounded="0"+rounded;
		decimalPointPosition=1
	}
	if(places!=0)
		{
		decimalPointPosition=(rounded+"").lastIndexOf(".");
		if(decimalPointPosition==-1||decimalPointPosition==rounded.length-1)
			{
			rounded+="."
		}
	}
	decimalPointPosition=(rounded+"").lastIndexOf(".");
	var currentPlaces=((rounded+"").length-1)-decimalPointPosition;
	if(currentPlaces<places)
		{
		for(x=currentPlaces;
		x<places;
		x++)
			{
			rounded+="0"
		}
	}
	return rounded
}
function resetform()
	{
	document.calc.reset();
	setVars();
	recalculate()
}
