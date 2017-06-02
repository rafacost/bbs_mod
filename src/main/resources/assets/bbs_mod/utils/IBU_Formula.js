var e=2.718281828459045235;
var boilsize=7;
var batchsize=5.5;
var originalgravity=1.05;
var volumeunit="Gallons";
var boilgravity;
var oz=new Array(6);
var aa=new Array(6);
var time=new Array(6);
var hoptype=new Array(6);
var divutil=new Array(6);
var divIBU=new Array(6);
var divtotalIBU;
var divboilgravity;
function switchUnitsToUs()
	{
	$(".volumeunit").html("(Gallons)");
	$(".weightunit").html("Ounces");
	volumeunit="Gallons";
	document.hops.txtboilsize.value="7";
	document.hops.txtbatchsize.value="5.5";
	setCookie("bfmetric","",-1);
	updateAll()
}
function switchUnitsToMetric()
	{
	$(".volumeunit").html("(Liters)");
	$(".weightunit").html("Grams");
	volumeunit="Liters";
	document.hops.txtboilsize.value="27";
	document.hops.txtbatchsize.value="21";
	setCookie("bfmetric","metric",(365*3));
	updateAll()
}
function setVars()
	{
	if(document.hops.hop1oz.value=='')
		{
		document.hops.hop1oz.value='0'
	}
	if(document.hops.hop2oz.value=='')
		{
		document.hops.hop2oz.value='0'
	}
	if(document.hops.hop3oz.value=='')
		{
		document.hops.hop3oz.value='0'
	}
	if(document.hops.hop4oz.value=='')
		{
		document.hops.hop4oz.value='0'
	}
	if(document.hops.hop5oz.value=='')
		{
		document.hops.hop5oz.value='0'
	}
	if(document.hops.hop6oz.value=='')
		{
		document.hops.hop6oz.value='0'
	}
	if(document.hops.hop1aa.value=='')
		{
		document.hops.hop1aa.value='0'
	}
	if(document.hops.hop2aa.value=='')
		{
		document.hops.hop2aa.value='0'
	}
	if(document.hops.hop3aa.value=='')
		{
		document.hops.hop3aa.value='0'
	}
	if(document.hops.hop4aa.value=='')
		{
		document.hops.hop4aa.value='0'
	}
	if(document.hops.hop5aa.value=='')
		{
		document.hops.hop5aa.value='0'
	}
	if(document.hops.hop6aa.value=='')
		{
		document.hops.hop6aa.value='0'
	}
	if(document.hops.hop1time.value=='')
		{
		document.hops.hop1time.value='0'
	}
	if(document.hops.hop2time.value=='')
		{
		document.hops.hop2time.value='0'
	}
	if(document.hops.hop3time.value=='')
		{
		document.hops.hop3time.value='0'
	}
	if(document.hops.hop4time.value=='')
		{
		document.hops.hop4time.value='0'
	}
	if(document.hops.hop5time.value=='')
		{
		document.hops.hop5time.value='0'
	}
	if(document.hops.hop6time.value=='')
		{
		document.hops.hop6time.value='0'
	}
	oz[0]=document.hops.hop1oz.value;
	oz[1]=document.hops.hop2oz.value;
	oz[2]=document.hops.hop3oz.value;
	oz[3]=document.hops.hop4oz.value;
	oz[4]=document.hops.hop5oz.value;
	oz[5]=document.hops.hop6oz.value;
	aa[0]=document.hops.hop1aa.value;
	aa[1]=document.hops.hop2aa.value;
	aa[2]=document.hops.hop3aa.value;
	aa[3]=document.hops.hop4aa.value;
	aa[4]=document.hops.hop5aa.value;
	aa[5]=document.hops.hop6aa.value;
	time[0]=document.hops.hop1time.value;
	time[1]=document.hops.hop2time.value;
	time[2]=document.hops.hop3time.value;
	time[3]=document.hops.hop4time.value;
	time[4]=document.hops.hop5time.value;
	time[5]=document.hops.hop6time.value;
	hoptype[0]=document.hops.hop1type[document.hops.hop1type.selectedIndex].value;
	hoptype[1]=document.hops.hop2type[document.hops.hop2type.selectedIndex].value;
	hoptype[2]=document.hops.hop3type[document.hops.hop3type.selectedIndex].value;
	hoptype[3]=document.hops.hop4type[document.hops.hop4type.selectedIndex].value;
	hoptype[4]=document.hops.hop5type[document.hops.hop5type.selectedIndex].value;
	hoptype[5]=document.hops.hop6type[document.hops.hop6type.selectedIndex].value;
	boilsize=document.hops.txtboilsize.value;
	batchsize=document.hops.txtbatchsize.value;
	originalgravity=document.hops.txtoriginalgravity.value;
	divutil[0]=document.getElementById('hop1util');
	divutil[1]=document.getElementById('hop2util');
	divutil[2]=document.getElementById('hop3util');
	divutil[3]=document.getElementById('hop4util');
	divutil[4]=document.getElementById('hop5util');
	divutil[5]=document.getElementById('hop6util');
	divIBU[0]=document.getElementById('hop1IBU');
	divIBU[1]=document.getElementById('hop2IBU');
	divIBU[2]=document.getElementById('hop3IBU');
	divIBU[3]=document.getElementById('hop4IBU');
	divIBU[4]=document.getElementById('hop5IBU');
	divIBU[5]=document.getElementById('hop6IBU');
	divtotalIBU=document.getElementById('divtotalIBU');
	divboilgravity=document.getElementById('divboilgravity')
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
		boilsize=litersToGallons(boilsize);
		oz[0]=gramsToOunces(oz[0]);
		oz[1]=gramsToOunces(oz[1]);
		oz[2]=gramsToOunces(oz[2]);
		oz[3]=gramsToOunces(oz[3]);
		oz[4]=gramsToOunces(oz[4]);
		oz[5]=gramsToOunces(oz[5])
	}
	boilgravity=(batchsize/boilsize)*(originalgravity-1);
	divboilgravity.innerHTML=rounddecimal(boilgravity+1,3);
	totalIBU=0;
	for(i=0;
	i<6;
	i++)
		{
		var IBU=0;
		var util=0;
		var bfactor=1.65*Math.pow(0.000125,boilgravity);
		var tfactor=(1-Math.pow(e,(-0.04*time[i])))/4.15;
		util=bfactor*tfactor;
		if(hoptype[i]=='pellet')
			{
			util=util*1.1
		}
		IBU=util*(((aa[i]/100) * oz[i] * 7490) /batchsize);
		divutil[i].innerHTML=rounddecimal(util,4);
		divIBU[i].innerHTML=rounddecimal(IBU,2);
		totalIBU=totalIBU+IBU
	}
	divtotalIBU.innerHTML=rounddecimal(totalIBU,2)
}
function checkInput()
	{
	setVars();
	if(!isNumber(boilsize))
		{
		alert('Boil Size must be a number');
		return false
	}
	if(!isNumber(batchsize))
		{
		alert('Batch Size must be a number');
		return false
	}
	if(!isNumber(originalgravity))
		{
		alert('Original Gravity must be a number');
		return false
	}
	for(i=0;
	i<6;
	i++)
		{
		if(!isNumber(oz[i])||!isNumber(aa[i])||!isNumber(time[i]))
			{
			alert('All values must be numbers.');
			return false
		}
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
	document.hops.reset();
	setVars();
	recalculate()
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
function gramsToOunces(grams)
	{
	grams=parseFloat(grams);
	if(isNaN(grams))
		{
		return false
	}
	return 0.0352739619*grams
}
