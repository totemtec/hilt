package com.demo.jiufengte.chapter05.b

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.Activity05Binding
import dagger.Component
import dagger.Module
import dagger.Provides

class Computer(private val name: String) {
    override fun toString(): String {
        return "Computer: $name"
    }
}

class Printer(private val name: String, private val cpu: Computer) {
    fun print() = "$cpu is working"
    override fun toString(): String {
        return "Printer: $name"
    }
}

@Module
class ComputerModule {
    @Provides
    fun getComputer() = Computer("Dell")
}

@Module
class PrinterModule {
    @Provides
    fun getPrinter(cpu: Computer) = Printer("HP", cpu)
}

@Component(modules = [ComputerModule::class])
interface ComputerComponent {
    fun makeComputer(): Computer
}

@Component(modules = [PrinterModule::class], dependencies = [ComputerComponent::class])
interface PrinterComponent {
    fun makePrinter(): Printer
}


class Activity05b : AppCompatActivity() {

    private lateinit var binding: Activity05Binding

    lateinit var myComputer: Computer
    lateinit var myPrinter: Printer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity05Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val cpuCom = DaggerComputerComponent.create()
        myComputer = cpuCom.makeComputer()

        myPrinter = DaggerPrinterComponent.builder().computerComponent(cpuCom).build().makePrinter()

        binding.buttonComputer.setOnClickListener {
            binding.textView.text = myComputer.toString()
        }

        binding.buttonPrinter.setOnClickListener {
            binding.textView.text = myPrinter.toString()
        }
    }


}

