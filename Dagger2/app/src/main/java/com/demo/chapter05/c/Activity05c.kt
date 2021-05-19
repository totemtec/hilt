package com.demo.chapter05.c

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.Activity05cBinding
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

class Computer(private val name: String) {
    override fun toString(): String {
        return "Computer: $name"
    }
}

@Module
class ComputerModule {
    @Provides
    fun getComputer() = Computer("Dell")
}

@Component(modules = [ComputerModule::class])
interface ComputerComponent{
    fun makeComputer():Computer
    fun makeVirtualComponent():SubComponentVirtualPrinter
}

class Printer(private val name: String, private val cpu: Computer) {
    fun print() = "$cpu is working"
    override fun toString(): String {
        return "Printer: $name"
    }
}

@Module
class PrinterModule {
    @Provides
    fun getPrinter(cpu: Computer) = Printer("HP", cpu)
}

@Component(modules = [PrinterModule::class], dependencies = [ComputerComponent::class])
interface PrinterComponent {
    fun makePrinter(): Printer
}

class VirtualPrinter(private val name:String, private val cpu:Computer){
    override fun toString() = "VirtualPrinter:$name"
}

@Module
class VirtualPrinterModule{
    @Provides
    fun getVirtualPrinter(cpu:Computer)=VirtualPrinter("微软虚拟打印机", cpu)
}

@Subcomponent(modules = [VirtualPrinterModule::class])
interface SubComponentVirtualPrinter{
    fun makeVirtualPrinter():VirtualPrinter
}


class Activity05c : AppCompatActivity() {

    private lateinit var binding: Activity05cBinding

    lateinit var myComputer: Computer
    lateinit var myPrinter: Printer
    lateinit var myVirtualPrinter: VirtualPrinter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity05cBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cpuCom = DaggerComputerComponent.create()
        myComputer = cpuCom.makeComputer()

        myPrinter = DaggerPrinterComponent.builder().computerComponent(cpuCom).build().makePrinter()

        myVirtualPrinter = cpuCom.makeVirtualComponent().makeVirtualPrinter()

        binding.button.setOnClickListener {
            binding.infoView.text = "$myComputer \n $myPrinter \n $myVirtualPrinter \n ${myPrinter.print()}"
        }
    }
}

